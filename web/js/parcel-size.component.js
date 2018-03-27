
angular.
module('parcelConfig').
component('parcelSize', {
    transclude: true,
    template:
    '<div class="w3-card-2">'+
    '<div class="w3-container w3-teal">' +
    '<h2>Packetgröße</h2>' +
    '</div>' +

    '<form class="w3-container">' +

    '<p>' +
    '<label>Länge</label>' +
    '<input class="w3-input" type="text" id="cfg-parcel-length" ng-model="$ctrl.parcel.size.length">' +
    '</p>' +

    '<p>' +
    '<label>Breite</label>' +
    '<input class="w3-input" type="text" id="cfg-parcel-width" ng-model="$ctrl.parcel.size.width">' +
    '</p>' +

    '<p>' +
    '<label>Tiefe</label>' +
    '<input class="w3-input" type="text" id="cfg-parcel-depth" ng-model="$ctrl.parcel.size.depth">' +
    '</p>' +

    '<p>' +
    '<button class="w3-btn w3-teal" ng-click="$ctrl.parcel.calculate()">Größe berechnen</button>' +
    '<label>   Paketgröße: </label>' +
    '<label id="lbl-parcel-size">{{$ctrl.parcel.size.category}}</label>' +
    '</p>' +
    '</form>'+

    '</div>',

    controller: function ParcelSizeController($rootScope, $http) {
        this.parcel = {
            size:{
            length: $rootScope.length,
            width:  $rootScope.width,
            depth:  $rootScope.depth,
            category: ""},
            calculate: function () {
                this.size.category = "M";
            }
        };
    }
});


