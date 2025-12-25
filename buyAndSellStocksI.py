class Solution:
    def buy_and_sell_stocks_I(self, prices:list[int]) -> int:
        left, right = 0, 1
        maxProfit = 0

        while right < len(prices):
            if prices[left] > prices[right]:
                left = right
            else:
                maxProfit = max(maxProfit, prices[right] - prices[left])
                right += 1

        return maxProfit
    
s = Solution()
print(s.buy_and_sell_stocks_I([7,1,5,3,6,4]))
print(s.buy_and_sell_stocks_I([7,6,4,3,1]))
print(s.buy_and_sell_stocks_I([1,2,3,4,5]))
print(s.buy_and_sell_stocks_I([2,4,1]))