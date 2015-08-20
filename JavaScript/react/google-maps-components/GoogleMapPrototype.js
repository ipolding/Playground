var GoogleMap = React.createClass({

            getInitialState : function() {
                return {
                    markers: []
                    } 
            },

            addMarker : function(latLng, map) {

                var marker = {
                                position: latLng,    
                                map:map
                             }
                this.setState({markers: [marker]})

            },  

            componentDidMount :  function() {
                            console.log("component has mounted")
                            new google.maps.Map(React.findDOMNode(this.refs.map_canvas), 
                            {zoom: 8,
                             center: {lat: -34.397, lng: 150.644}
                            });

                var markerPosition = {lat: this.props.lat, lng: this.props.lng}

                            // this.addMarker(markerPosition, map)
            },

            render: function() {
                            console.log("rendering")
                                            return <div ref="map_canvas" className="bigMap">
                                                                </div>
            }
});