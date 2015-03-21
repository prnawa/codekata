#Stop loss kata

##Problem description (Trailing Stop Loss)

A “trailing stop loss” is a term used in financial trading: Imagine you buy into a stock at a price of, say, 10p.
You want it to be sold automatically if the price falls below 9p (ie. -1p). The term "trailing" means also that if the price goes up to 11p, then the sell point becomes 10p. That is, our sell trigger price tracks the stock price upwards.Furthermore, in “real life” prices can fluctuate rapidly, and we need to dampen those effects.
So a price should only be considered to have moved up if it is held for more than 15 seconds, and the stop loss should only be triggered if a lowered price point is held for more than 30 seconds.

The kata is to create something that implements a trailing stop loss and to do it with TDD.

Assume that you will receive a "PriceChanged" message every time the price changes. Just implement it as a method that receives that message (assume later you will hook it up into something that provides that).

> For extra points...

> Can you do it without holding any state except for an integer variable? What trade offs would you have to make?
