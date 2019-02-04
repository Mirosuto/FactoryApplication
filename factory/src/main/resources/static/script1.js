var app = angular.module('Application', ['ui.router']);

app.controller('mainController', function ($scope, $location) {
    $scope.vehicle = [
        {name: "Car", type: [{name: "Classic"}, {name: "Convertible"}]},
        {name: "Bus", type: [{name: "City"}, {name: "Travel"}]},
        {name: "Truck", type: [{name: "Tank"}, {name: "Tow"}]}];


    $scope.open = function (vozilo) {
        $location.path('/' + vozilo.name);
        $scope.getAllVehicles();
    };

    $scope.getAllVehicles = function () {
        $.ajax({
            url: "/vehicle/get-all-" + $scope.vozilo.name,
            method: "GET",
            success: function (data) {
                $scope.listOfVehicles = data;
                $scope.$apply();
                console.log(data)},
            error(xhr) {
                console.log(xhr);
                alert("failed to retrieve data!");
            }
        });
    };

    $scope.GetVehiclesOnParking = function (selectedParking) {
        $.ajax({
            url: "/vehicle/get-parking-" + selectedParking,
            method: "GET",
            success: function (data) {
                $scope.listOfVehiclesOnParking = data;
                $scope.$apply();
                console.log(data)},
            error(xhr) {
                console.log(xhr);
                alert("failed to retrieve data!");
            }
        });
    };


    $scope.saveCity = function (vehiclea) {
        $.ajax({
            url: "/vehicle/add-City",
            method: "POST",
            data: {
                    name: vehiclea.qname,
                    color: vehiclea.qcolor,
                    numberOfSeats: vehiclea.qnumberOfSeats,
                    numberOfStanding: vehiclea.qnumberOfStanding,
                    articular: vehiclea.qarticular,
            },
            success: function () {
                    $scope.getAllVehicles();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + " " + jqXHR.responseText + " " + textStatus + " " + errorThrown);
            }
        });
    }

    $scope.saveClassic = function (vehiclea) {
        $.ajax({
            url: "/vehicle/add-Classic",
            method: "POST",
            data: {
                marka: vehiclea.qname,
                boja: vehiclea.qcolor,
                seatNbr: vehiclea.qnbrOfSeats,
                equipment: vehiclea.qequipment,
                roofCarryCapacity: vehiclea.qroofCarryCapacity,
            },
            success: function () {
                $scope.getAllVehicles();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + " " + jqXHR.responseText + " " + textStatus + " " + errorThrown);
            }
        });
    }

    $scope.saveConvertible = function (vehiclea) {
        $.ajax({
            url: "/vehicle/add-Convertible",
            method: "POST",
            data: {
                marka: vehiclea.qname,
                boja: vehiclea.qcolor,
                seatNbr: vehiclea.qnumberOfSeats,
                equipment: vehiclea.qequipment,
                roof: vehiclea.qroof,
            },
            success: function () {
                $scope.getAllVehicles();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + " " + jqXHR.responseText + " " + textStatus + " " + errorThrown);
            }
        });
    };

    $scope.saveTank = function (vehiclea) {
        $.ajax({
            url: "/vehicle/add-Tank",
            method: "POST",
            data: {
                marka: vehiclea.qname,
                boja: vehiclea.qcolor,
                numberOfAxles: vehiclea.qaxels,
                tankCapacity: vehiclea.qtankCapacity
            },
            success: function () {
                $scope.getAllVehicles();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + " " + jqXHR.responseText + " " + textStatus + " " + errorThrown);
            }
        });
    }

    $scope.saveTow = function (vehiclea) {
        $.ajax({
            url: "/vehicle/add-Tow",
            method: "POST",
            data: {
                marka: vehiclea.qname,
                boja: vehiclea.qcolor,
                numberOfAxles: vehiclea.qaxels,
                towingCapacity: vehiclea.qtowingCapacity
            },
            success: function () {
                $scope.getAllVehicles();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + " " + jqXHR.responseText + " " + textStatus + " " + errorThrown);
            }
        });
    }

    $scope.saveTravel = function (vehiclea) {
        $.ajax({
            url: "/vehicle/add-Travel",
            method: "POST",
            data: {
                marka: vehiclea.qname,
                boja: vehiclea.qcolor,
                numberOfSeats: vehiclea.qnumberOfSeats,
                numberOfStanding: vehiclea.qnumberofPlacesToStand,
                trunkCapacity: vehiclea.qtrunkCapacity
            },
            success: function (data) {
                $scope.getAllVehicles();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + " " + jqXHR.responseText + " " + textStatus + " " + errorThrown);
            }
        });
    }

});

app.config(['$stateProvider', function ($stateProvider) {

    $stateProvider
        .state('cityBus', {
            url: '/City',
            templateUrl: 'city-bus.html'
        })

        .state('travelBus', {
            url: '/Travel',
            templateUrl: 'travel-Bus.html'

        })
        .state('classicCar', {
            url: '/Classic',
            templateUrl: 'classic-car.html'
        })
        .state('convertibleCar', {
            url: '/Convertible',
            templateUrl: 'convertible-car.html'
        })
        .state('tankTruck', {
            url: '/Tank',
            templateUrl: 'tank-truck.html'
        })
        .state('towTruck', {
            url: '/Tow',
            templateUrl: 'tow-truck.html'
        })

}]);
