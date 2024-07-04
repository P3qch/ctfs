console.log("Script loaded successfully ");
Java.perform(function() {
    // Find the class
    var targetClass = Java.use('b.a.a.d');
    console.log('loaded class')
    // Hook the method

    targetClass.d.overload('java.lang.String', 'java.lang.String').implementation = function(cipherFlag, encode_tag) {
        // Call the original method
        var result = this.d("l5wMg7HQCuXMk3Dkf3GDlLX52+VM0bZcDCQIZjyVJlKZ3hh9LMIUY13zzlgimU3IAAAAAAAAAAAAAAAAAAAAAA==", "Tfcv8SdMzbVGThvKPAOlRw==");

        // Log the inputs and output
        console.log('cipherFlag: ' + cipherFlag);
        console.log('encode_tag: ' + encode_tag);
        console.log('Decrypted Flag: ' + result);

        // Return the result
        return result;
    };
});