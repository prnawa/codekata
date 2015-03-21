var StopLoss = function (buyingPrice, sellCallback) {
    this.sellCallback = sellCallback || function () {};
    this.stockPrice = buyingPrice;
};

StopLoss.prototype.getSellingPoint = function () {
    return this.stockPrice - 1;
};

StopLoss.prototype.priceChanged = function (newPrice) {
    var self = this;
    if (this.timeoutPriceUp) {
        clearTimeout(this.timeoutPriceUp);
    }

    if (this.timeoutSell) {
        clearTimeout(this.timeoutSell);
    }

    this.timeoutPriceUp = setTimeout(function () {
        if (self.stockPrice < newPrice) {
            self.stockPrice = newPrice;
        }
    }, 15);

    this.timeoutSell = setTimeout(function () {
        var shouldSell = self.getSellingPoint() > newPrice;
        if (shouldSell) {
            self.sellCallback();
        }
    }, 30);

};

module.exports = StopLoss;
