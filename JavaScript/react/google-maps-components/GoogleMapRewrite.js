var GoogleMap = React.createClass({

        render: function() {
        console.log("rendering")
        return <div className="GMap">
              <div ref="map_canvas">
                    </div>
        </div>
    },

    componentDidMount :  function() {
        console.log("component has mounted")
        new google.maps.Map(React.findDOMNode(this.refs.map_canvas), {
            zoom: 8,
            center: {lat: -34.397, lng: 150.644}
        });
    }


});
