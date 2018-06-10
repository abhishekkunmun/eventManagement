event.controller('eventCtrl', function($scope, $location, $http, $filter, $localStorage,Upload) {

$scope.eventForm={};
$scope.modalShow=false;
$scope.idCard = null;
$scope.allEvents=[];
$scope.modal={};

  $scope.fetchAllEvents = function() {
      var res = $http.get("events");
      res.success(function(data) {

        $scope.message = "Success";
        $scope.allEvents = data;
        $localStorage.allGames = $scope.allGames;
        console.log(data);
        $scope.loading = false;

      });
      res.error(function(data, status, headers, config) {
        $scope.loading = false;
        $scope.message = "Error while fetching games";
      });
    };


  $scope.upload = function() {
      var fd = new FormData();
      fd.append('modelEvent', JSON.stringify($scope.eventForm));
      fd.append('file', $('#idCard')[0].files[0]);
      $http.post("events", fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(data){
          console.log(data);
          $scope.modal.title="Event added successfully with event Id " +data.eventId;
          $scope.modal.data = data;
          $scope.modal.data.idCard = 'idcard/'+data.eventId;
          $('#myModal').modal('show');

        })
        .error(function(data){
          console.log(data);
          $scope.modal.title="Event addition failed  ";
          $scope.modal.data = data;
          $('#myModal').modal('show');

        });
  };







});
