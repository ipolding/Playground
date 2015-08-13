var GoogleMap = React.createClass({

    map : null,

    addMarker : function(place) {
        var marker =
            new google.maps.Marker({
                map: this.map,
                anchorPoint: new google.maps.Point(0, -29)
            });

             

        marker.setIcon(({
            url: place.icon,
            size: new google.maps.Size(71, 71),
            origin: new google.maps.Point(0, 0),
            anchor: new google.maps.Point(17, 34),
            scaledSize: new google.maps.Size(35, 35)
        }));
            
    },

    placeSearchCallback : function(placeResultArray, placesServiceStatus, placeSearchPagination) {
            this.addMarker(placeResultArray[0])
  },

    addPlace : function(address) {
        var placesService = new google.maps.places.PlacesService(map);
        var request = {query:address}    
          placesService.textSearch(request, this.placeSearchCallback)
    },

    componentDidMount :  function() {
        console.log("component has mounted")
        map = new google.maps.Map(React.findDOMNode(this.refs.map_canvas), {
            zoom: 8,
            center: {lat: 51.50417, lng: 0}        });
           

        this.addPlace("Local Government Association, Smith Square, City of London, London, United Kingdom");
    },

    render: function() {
        console.log("rendering")
        return <div ref="map_canvas" className="bigMap">
                    </div>
        
            }
});