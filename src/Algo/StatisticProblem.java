package Algo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticProblem {
    public Map<String, Statistic> collectStatistic(List<BrokerageAccount> accounts) {

        Map<String, Statistic> map = new HashMap<>();
        for (BrokerageAccount account : accounts) {
            if (account.getValuation().intValue() > 5000) {
                Map<String, BigDecimal> statisticMap = new HashMap<>();
                Map<String, Long> tickerCountMap = new HashMap<>();
                for (Security security : account.getSecurities()) {
                    String ticker = security.getTicker();
                    BigDecimal money = security.getMoney();
                    if (statisticMap.containsKey(ticker)) {
                        statisticMap.replace(ticker, statisticMap.get(ticker).add(money));
                        tickerCountMap.replace(ticker, tickerCountMap.get(ticker) + 1L);
                    } else {
                        tickerCountMap.put(ticker, 1L);
                        statisticMap.put(ticker, money);

                    }
                }
                for (Map.Entry<String, BigDecimal> stat : statisticMap.entrySet()) {
                    map.put(stat.getKey(), new Statistic(tickerCountMap.get(stat.getKey()), stat.getValue()));
                }

            }
        }
        return map;
    }


    class Statistic {
        private long count;
        private BigDecimal sum;

        public Statistic(Long aLong, BigDecimal value) {

        }

        public long getCount() {
            return count;
        }

        public BigDecimal getSum() {
            return sum;
        }
    }

    class BrokerageAccount {
        public String getAccountNumber() {
            return accountNumber;
        }

        public BigDecimal getValuation() {
            return valuation;
        }

        public List<Security> getSecurities() {
            return securities;
        }


        private String accountNumber;
        private BigDecimal valuation;
        private List<Security> securities;
    }

    class Security {
        private String ticker;

        private BigDecimal money;

        public String getTicker() {
            return ticker;
        }

        public BigDecimal getMoney() {
            return money;
        }
    }

}
