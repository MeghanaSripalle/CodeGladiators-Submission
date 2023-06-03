import sys
import requests
import json
from dotenv import dotenv_values
config = dotenv_values("../config/.env")

# write a function that accepts a city's name from the command line interface and if city name is more than 1 word then asks for how many words long the city name is and uses those many arguments to get the city name and  handles if argument not given,stores the city name and then returns the city name
def get_city_name():
    city_name = ''
    if len(sys.argv) > 1:
        city_name = ' '.join(sys.argv[1:])
    else:
        city_name = input('Enter the city name: ')
    return city_name

# write a function that uses the city name from the get_city_name function and fetches the weather forecast of the city from the OpenWeatherMap API and handles the various possible errors
def get_weather_data(city_name):
    api_key = config["API_KEY"]
    url = f'http://api.openweathermap.org/data/2.5/weather?q={city_name}&appid={api_key}&units=metric'
    try:
        response = requests.get(url)
        if response.status_code != 200:
            print('Could not fetch the weather data')
            sys.exit(1)
        weather_data = response.json()
        return weather_data
    except requests.exceptions.RequestException as e:
        print("An error occurred while fetching weather data:", str(e))
        sys.exit(1)
    except json.JSONDecodeError:
        print("Invalid JSON response from the API.")
        sys.exit(1)

# write a function that uses the weather data from the get_weather_data function and prints the weather data with emphasis on each parameter in a readable format
def print_weather_data(weather_data):
    print(f'City: {weather_data["name"]}')
    print(f'Country: {weather_data["sys"]["country"]}')
    print(f'Temperature: {weather_data["main"]["temp"]}°C')
    print(f'Feels like: {weather_data["main"]["feels_like"]}°C')
    print(f'Minimum Temperature: {weather_data["main"]["temp_min"]}°C')
    print(f'Maximum Temperature: {weather_data["main"]["temp_max"]}°C')
    print(f'Pressure: {weather_data["main"]["pressure"]} hPa')
    print(f'Humidity: {weather_data["main"]["humidity"]}%')
    print(f'Wind Speed: {weather_data["wind"]["speed"]} m/s')
    print(f'Wind Direction: {weather_data["wind"]["deg"]}°')
    print(f'Cloudiness: {weather_data["clouds"]["all"]}%')
    print(f'Weather: {weather_data["weather"][0]["main"]}')
    print(f'Weather Description: {weather_data["weather"][0]["description"]}')
    print(f'Visibility: {weather_data["visibility"]} m')
    print(
        f'Precipitation: {weather_data["rain"] if "rain" in weather_data else 0} mm')
    print(f'Snow: {weather_data["snow"] if "snow" in weather_data else 0} mm')
    print(f'Sunrise: {weather_data["sys"]["sunrise"]}')
    print(f'Sunset: {weather_data["sys"]["sunset"]}')

    # export the weather data into a json file in the src directory
    with open('weather_data.json', 'w') as f:
        json.dump(weather_data, f, indent=2)

# write a function that calls the get_city_name, get_weather_data, and print_weather_data functions and handles the errors accordingly


def main():
    city_name = get_city_name()
    weather_data = get_weather_data(city_name)
    if weather_data:
        print_weather_data(weather_data)


if __name__ == '__main__':
    main()
