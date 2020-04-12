/**
 * @param {string} text
 * @return {string}
 */
const entityParser = (text) => text
    .replace(/&quot;/g, '"')
    .replace(/&apos;/g, "'")
    .replace(/&amp;/g, '&')
    .replace(/&gt;/g, '>')
    .replace(/&lt;/g, '<')
    .replace(/&frasl;/g, '/');
