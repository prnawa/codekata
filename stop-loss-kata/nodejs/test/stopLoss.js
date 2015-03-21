var proxyquire = require('proxyquire');
var should = require('chai').should();

describe('Stop loss', function () {

    var getStopLoss;

    beforeEach(function () {
        getStopLoss = function () {
            return proxyquire('../stopLoss', {});
        };
    });

    describe('buying into a stock at 10p', function () {
        describe('selling point', function () {
            it('should be equal to 9p - 1.0', function (done) {
                var buyingPrice = 10;
                var sellingPrice = 9;
                var TrailingStopLoss = getStopLoss();
                var trailingStopLoss = new TrailingStopLoss(buyingPrice);
                trailingStopLoss.getSellingPoint().should.equal(sellingPrice);
                done();
            });
        });

        describe('price goes up to 11p', function () {
            describe('selling point', function () {
                it.skip('should be equal to 10p - 1.1', function (done) {
                    var buyingPrice = 10;
                    var newPrice = 11;
                    var sellingPrice = 10;
                    var TrailingStopLoss = getStopLoss();
                    var trailingStopLoss = new TrailingStopLoss(buyingPrice);
                    trailingStopLoss.priceChanged(newPrice);
                    trailingStopLoss.getSellingPoint().should.equal(sellingPrice);
                    done();
                });
            });
        });

        describe('price goes up to 11p and it is held for 15s', function () {
            describe('selling point', function () {
                it('should be equal to 10p - 1.2', function (done) {
                    var buyingPrice = 10;
                    var newPrice = 11;
                    var sellingPrice = 10;
                    var TrailingStopLoss = getStopLoss();
                    var trailingStopLoss = new TrailingStopLoss(buyingPrice);
                    setTimeout(function () {
                        trailingStopLoss.priceChanged(newPrice);
                    }, 2);

                    setTimeout(function () {
                        trailingStopLoss.getSellingPoint().should.equal(sellingPrice);
                        done();
                    }, 20);
                });
            });
        });

        describe('price goes up to 11p and goes down to 10p with in 15s', function () {
            describe('selling point', function () {
                it('should equal to 9p during and after 15s - 1.3', function (done) {
                    var buyingPrice = 10;
                    var newPrice1 = 11;
                    var newPrice2 = 10;
                    var sellingPrice = 9;
                    var TrailingStopLoss = getStopLoss();
                    var trailingStopLoss = new TrailingStopLoss(buyingPrice);
                    setTimeout(function () {
                        trailingStopLoss.priceChanged(newPrice1);
                    }, 4);

                    setTimeout(function () {
                        trailingStopLoss.priceChanged(newPrice1);
                    }, 8);

                    setTimeout(function () {
                        trailingStopLoss.getSellingPoint().should.equal(sellingPrice, "Selling point @ 1s");
                    }, 1);

                    setTimeout(function () {
                        trailingStopLoss.getSellingPoint().should.equal(sellingPrice, "Selling point @ 6s");
                    }, 6);

                    setTimeout(function () {
                        trailingStopLoss.getSellingPoint().should.equal(sellingPrice, "Selling point @ 10s");
                        done();
                    }, 10);
                });
            });
        });

        describe('price goes gown to 9p and it is held for 15s', function () {
            describe('selling point', function () {
                it('should be equal to 9p - 1.4', function (done) {
                    var buyingPrice = 10;
                    var newPrice = 9;
                    var sellingPrice = 9;
                    var TrailingStopLoss = getStopLoss();
                    var trailingStopLoss = new TrailingStopLoss(buyingPrice);
                    setTimeout(function () {
                        trailingStopLoss.priceChanged(newPrice);
                    }, 2);

                    setTimeout(function () {
                        trailingStopLoss.getSellingPoint().should.equal(sellingPrice);
                        done();
                    }, 20);
                });
            });
        });

        describe('price goes down to 9p and and it is held for 30s', function () {
            describe('stop loss', function () {
                it('should trigger to sell sticok automatically - 1.5', function (done) {
                    var buyingPrice = 10;
                    var newPrice = 8;
                    var stopLossTriggerCallback = function () {
                        done();
                    };

                    var TrailingStopLoss = getStopLoss();
                    var trailingStopLoss = new TrailingStopLoss(buyingPrice, stopLossTriggerCallback);
                    trailingStopLoss.priceChanged(newPrice);
                });
            });
        });

        describe('price goes down to 8p and goes up to 11p again', function () {
            describe('stop loss', function () {
                it.only('should not trigger to sell sticok automatically - 1.6', function (done) {
                    var buyingPrice = 10;
                    var newPrice1 = 8;
                    var newPrice2 = 11;
                    var stopLossTriggerCallback = function () {
                        done('Error : should not trigger this');
                    };

                    var TrailingStopLoss = getStopLoss();

                    var trailingStopLoss = new TrailingStopLoss(buyingPrice, stopLossTriggerCallback);

                    setTimeout(function () {
                        trailingStopLoss.priceChanged(newPrice1);
                    }, 1);

                    setTimeout(function () {
                        trailingStopLoss.priceChanged(newPrice2);
                    }, 17);

                    setTimeout(done, 55);
                });
            });
        });
    });
});
