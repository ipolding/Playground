var PlacesAutocomplete = React.createClass({

    componentDidMount :  function() {
        new google.maps.places.Autocomplete(React.findDOMNode(this.refs.placeAutocomplete));
    },

    render: function() {
            return <input type="text" ref="placeAutocomplete">


            </input>
            }
});