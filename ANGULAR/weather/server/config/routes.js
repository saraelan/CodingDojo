var path = require('path');
module.exports = function(app){
  app.all('*', (req, res, next) => {
        res.sendFile(path.resolve("./client/dist/client/index.html"))
    });
    
};