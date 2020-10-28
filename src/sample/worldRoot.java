package sample;

import java.util.List;

public class worldRoot {
  public   Data data;


    public class CountriesStat{
        public String country_name;
        public String cases;
        public String deaths;
        public String region;
        public String total_recovered;
        public String new_deaths;
        public String new_cases;
        public String serious_critical;
        public String active_cases;
        public String total_cases_per_1m_population;
        public String deaths_per_1m_population;
        public String total_tests;
        public String tests_per_1m_population;
    }

    public class WorldTotal{
        public String total_cases;
        public String new_cases;
        public String total_deaths;
        public String new_deaths;
        public String total_recovered;
        public String active_cases;
        public String serious_critical;
        public String total_cases_per_1m_population;
        public String deaths_per_1m_population;
        public String statistic_taken_at;
    }

    public class Data{
        public List<CountriesStat> countries_stat;
        public String statistic_taken_at;
        public WorldTotal world_total;
    }


}
