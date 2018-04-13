package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParcelSize {
    private int length;
    private int width;
    private int height;
    private String category;

    public ParcelSize(int length, int width, int height,String category) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.category = category;
    }

    public ParcelSize(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.category = "";
    }

    public ParcelSize() {
        this.length = 0;
        this.width = 0;
        this.height = 0;
        this.category = "";
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateGurtmas(){
        int longest_side = Math.max(this.height, Math.max(this.width, this.length));
        return longest_side + 2*width + 2*height;
    }


}
