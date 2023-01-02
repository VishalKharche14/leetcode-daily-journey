/**
 * @param {string} word
 * @return {boolean}
 */
var detectCapitalUse = function(word) {
    
    return word == word.toUpperCase() || word == word.toLowerCase() ||
    (word.substring(1) == word.substring(1).toLowerCase() && word.charAt(0) >= 'A') ;
};