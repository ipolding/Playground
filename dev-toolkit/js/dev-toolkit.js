    function cleanUp() {
    var whitespace = /\s+/g
    var wow_prefix = /^wow/i
    var input = document.getElementById("gitBranchInput").value;

    document.getElementById("gitBranchOutput").innerHTML = input.trim().replace(whitespace, "-").replace(wow_prefix, "WOW");
    }

    function base64Decode() {
        var encodedData = document.getElementById("base64Input").value;
        var decodedData = window.atob(encodedData);
        document.getElementById("base64Output").innerHTML = decodedData;
    }

    /* Listeners*/

    /* git Brancher */
    document.getElementById("gitBranchInput").addEventListener("keyup", cleanUp, false); 
        document.getElementById("base64Input").addEventListener("keyup", base64Decode, false); 

    document.getElementById("copyButton").addEventListener("click", function() {window.alert(document.getElementById("output").innerHTML)}, false); 
    document.getElementById("decodeButton").addEventListener("click", base64Decode, false); 