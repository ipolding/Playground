var GoogleMap = React.createClass({

    componentDidMount :  function() {
        console.log("component has mounted")
        new google.maps.Map(React.findDOMNode(this.refs.map_canvas), {
            zoom: 8,
            center: {lat: -34.397, lng: 150.644}
        });
    },

    render: function() {
        console.log("rendering")
        return <div ref="map_canvas">
                    </div>
        
            }
});
