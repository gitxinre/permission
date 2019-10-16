/**
 * 加密（aes）
 * @param word
 * @returns {string}
 */
function encrypt(word){
    var srcs = CryptoJS.enc.Utf8.parse(word);
    var encrypted = CryptoJS.AES.encrypt(srcs, key, {mode:CryptoJS.mode.ECB,padding: CryptoJS.pad.Pkcs7});
    return encrypted.toString();
}

/**
 * 解密（aes）
 * @param word
 * @returns {*}
 */
function decrypt(word){
    var decrypt = CryptoJS.AES.decrypt(word, CryptoJS.enc.Utf8.parse('flhgctyf1005144X'), {mode:CryptoJS.mode.ECB,padding: CryptoJS.pad.Pkcs7});
    return CryptoJS.enc.Utf8.stringify(decrypt).toString();
}