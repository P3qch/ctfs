Java.perform(function() {
    var RandomAccessFile = Java.use("java.io.RandomAccessFile");
    var result = "";

    RandomAccessFile.writeChar.overload("int").implementation = function(c){
        if (c != 10)
        {
            result += String.fromCharCode(c);
            console.log(result);
        }

    };
});