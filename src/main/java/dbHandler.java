import java.sql.*;
import java.util.Date;


public class dbHandler {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public String getSize(int gurtmas){
        String result = "None";
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/parceldb?"
                            + "user=parceluser&password=parcelpwd");
            System.out.println("Gurtmaß: " + gurtmas);
            preparedStatement = connect.prepareStatement(" SELECT size FROM parceldb.parcelsize WHERE min_size < ? and ? <= max_size");
            preparedStatement.setInt(1, gurtmas);
            preparedStatement.setInt(2, gurtmas);
            resultSet = preparedStatement.executeQuery();
            System.out.println("Statement: " + resultSet.getStatement().toString());
            while (resultSet.next()) {
                result = resultSet.getString(1);
            }
            preparedStatement.close();
            connect.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean isDbConnected() {
        final String CHECK_SQL_QUERY = "SELECT 1";
        boolean isConnected = false;
        try {
            final PreparedStatement statement = connect.prepareStatement(CHECK_SQL_QUERY);
            isConnected = true;
        } catch (SQLException | NullPointerException e) {
            // handle SQL error here!
        }
        return isConnected;
    }
}
