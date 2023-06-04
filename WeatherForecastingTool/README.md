# Weather Forecasting


This is a command-line tool developed using Python that leverages the OpenWeather API to retrieve real-time weather data and present the current weather forecast for a specified city. The tool provides essential weather information, including temperature, humidity, wind speed, and atmospheric conditions. By using this tool, users can conveniently access up-to-date weather forecasts for any desired city, enabling them to stay well-informed about the prevailing weather conditions.

## Prerequisites

- Python 3.7
- requests
- dotenv
- json

## Installation

- Clone this repository
- Create a `.env` file in the `config` directory and add your API key from the OpenWeatherMap API

## Usage

Run the program by providing the city name as an argument to the program.

```bash
python weather.py <city-name>
```

<!-- If the city name is more than one word, provide the number of words in the city name as an argument.

```bash
python weather.py <number-of-words> <city-name>
``` -->

The program utilizes the OpenWeatherMap API to retrieve weather data, which is then stored in a JSON file `weather_data.json`. Additionally, the program displays the weather data in a readable format within the command prompt.
