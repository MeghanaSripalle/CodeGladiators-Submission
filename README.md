# Weather Forecasting

This is a python program to get the weather forecast of a city from the OpenWeatherMap API.

## Prerequisites

- Python 3.7
- [requests](https://requests.readthedocs.io/en/master/)
- [dotenv](https://pypi.org/project/python-dotenv/)

## Installation

- Clone this repository
- Create a `.env` file in the `config` directory and add your API key from the OpenWeatherMap API
- Install the required packages by running `pip install -r requirements.txt`

## Usage

Run the program by providing the city name as an argument to the program.

```bash
python weather.py <city-name>
```

If the city name is more than one word, provide the number of words in the city name as an argument.

```bash
python weather.py <number-of-words> <city-name>
```

The program will fetch the weather data from the OpenWeatherMap API and store it in a `weather_data.json` file in the `src` directory. It will also print the weather data in a readable format.
