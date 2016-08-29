package weatherUI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import weatherData.CityWeatherData;
import weatherData.Location;
import weatherData.WeatherDb;

class WeatherTablePanel extends JPanel  {
	private static final long serialVersionUID = 1L;
	private WeatherDb weatherDb;
     private JLabel cityNameLbl;
     private JLabel curTempLbl;
     private CityWeatherData curWeather;

     public WeatherTablePanel(WeatherDb weatherDb) {
         this.weatherDb = weatherDb;
         cityNameLbl = new JLabel("Unknown City");
         curTempLbl = new JLabel("Temperature Not Set");
         
         add(cityNameLbl);
         add(curTempLbl);
    }

    public void setNewLocation(Location newLoc) {
    	String cityName;
    	
    	if (curWeather == null || !curWeather.hasLocation(newLoc)) {
    		curWeather = weatherDb.getLocWeather(newLoc);
    		cityName = newLoc.getCity();
    		cityNameLbl.setText(cityName);
    	}
    	
    	updateWeatherData();
    }

    public void updateWeatherData() {
        int curTemp;
        
        curTemp = curWeather.getTemp();
        curTempLbl.setText("" + curTemp);
   }
                           
}

