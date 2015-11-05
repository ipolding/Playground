var TextEntry = React.createClass({

  getInitialState: function() {

    var text = this.props.initialValue;
    var index = this.props.index;
    return {
      index: index,
      text: text  
    };
  },

  handleChange : function(e) {
    this.setState(
      {
        index : this.props.dataPosition,
        text : e.target.value
      }
      );
  },

  handleBlur : function(e) {
    if (typeof this.props.index !== 'undefined') {
        this.props.updateEntry(this.props.index, this.state.text);  
    } else if (e.target.value) {            
        this.createEntry();
        this.flushState();          
      }
                   
    },

  createEntry : function() {
    var textEntry = this.refs.textEntry.value;
    this.props.createEntry(textEntry);               
  },

  flushState : function() {
    this.setState(
      {
        index : this.props.dataPosition,
        text : ''
      }
      );
  },

  keyHasBeenPressed : function(e) {
      if (e.keyCode == 13) {
        this.flushState();      
        
        this.createEntry();
      }      
  },

  render: function() {
     var message = this.state.message;
     return (
      <div>
        <input placeholder="Artist..." 
               value={this.state.text} 
               className="previousTextEntry" 
               onBlur={this.handleBlur} 
               onChange={this.handleChange} 
               onKeyDown={this.keyHasBeenPressed}
               ref="textEntry"/>          
      </div>
    );
  }
});

var PreviousTextEntries = React.createClass({
  
  render: function() {
      var updateEntry = this.props.updateEntry;
      var createEntry = this.props.createEntry;
      var parentData = this.props.data;
      var textEntryNodes = parentData.map(function (textEntry) {
      
      return (
        <TextEntry 
              key={textEntry.index}
              index={textEntry.index}
              initialValue={textEntry.value}
              createEntry={createEntry} 
              />
      );
    });
    return (
      <div className="PreviousTextEntries">
        {textEntryNodes}
      </div>
    );
  }});

var TextEntryBox = React.createClass({

  handleSubmit : function(e) {
    e.preventDefault();
    return false;
  },

  render: function() {
    return (
      <div className="textEntryBox" onSubmit={this.handleSubmit}>
        <h1>Artists</h1>
        <PreviousTextEntries updateEntry={this.props.updateEntry} createEntry={this.props.createEntry} data={this.props.data} />
        <TextEntry updateEntry={this.props.updateEntry} createEntry={this.props.createEntry} data={this.props.data} />
        </div>
    );
  }
});

var PlayListSubmitter = React.createClass({

  updateEntry: function(index, value) {
      var modifiedArray = this.state.data;
      console.log("modifiedArray " + JSON.stringify(modifiedArray));
      modifiedArray[index].value = value;
      this.setState({
      children: this.state.children++,
      data: modifiedArray
    });
  },

  createEntry: function(text) {
    var textEntries = this.state.data;
    var newTextEntrys = textEntries.concat([{index: this.state.children++, value: text}]);
    this.setState({
      children: this.state.children++,
      data: newTextEntrys
    });
  },

  getInitialState: function() {
    return {
      children : 0,
      data: []};
  },

  getPlaylist : function() {
    
    console.log("Sending: " + this.toJson())
  },

  render: function() {
    return (
      <div className="playlister" onSubmit={this.handleSubmit}>
        <TextEntryBox updateEntry={this.updateEntry} createEntry={this.createEntry} data={this.state.data}/>
        <button onClick={this.getPlaylist} className="btn btn-primary btn-lg">Get Top Tracks! &raquo;</button>
      </div>
    );
  },

  toJson : function() {
    console.log("PlayListSubmitter state : " + JSON.stringify(this.state.data));
    var stringArray = this.state.data.map(getTextEntryValues);
    return stringArray;
   }
});

ReactDOM.render(
  <PlayListSubmitter />,
  document.getElementById('artistList')
);

function getTextEntryValues(textEntry) {
    return textEntry.value;
}