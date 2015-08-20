var GoogleMapComposite = React.createClass({

    addMarker : function(latLng, map) {

        var marker = new google.maps.Marker({
            position: latLng,
            map: map,
            title: 'Hello World!'
        });

        console.log(this.refs.map.state)
                
    },  

    componentDidMount :  function() {
       console.debug("composite mounted")
    },

    communicateWithChild : function() {
        console.log("what is my child doing?");
        console.log(this.props.children.count);
    },

    render: function() {
    
    return  <div >
    <button onClick={this.communicateWithChild}>CLIIICK</button>
                <GoogleMap ref="map" lat={this.props.lat} lng={this.props.lng}/>                
                <Directions ref="directionsService" dance="Jiving"/>                
            </div>
            }
});