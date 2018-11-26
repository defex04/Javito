import csv
import numpy as np
from sklearn.svm import SVR
import matplotlib.pyplot as plt
import pandas as pd

dates = []
prices = []

df = pd.read_csv(r'C:\Users\andre\Desktop\DeBa\Javito\javito\lol.csv')
df.info


def get_data(filename):
    i = 0
    with open(filename, 'r') as csvfile:
        csvfileReader = csv.reader(csvfile, delimiter=';')
        next(csvfileReader)
        for row in csvfileReader:
            dates.append(i)
            prices.append(float(row[1]))
            i = i + 1
    return


def predict_prices(dates, prices, x):
    dates = np.reshape(dates, (len(dates), 1))
    svr_lin = SVR(kernel='linear', C=100)
    #  svr_poly = SVR(kernel = 'poly', C=1e3, degree = 2)
    svr_rbf = SVR(kernel='rbf', C=100, gamma=10)
    svr_lin.fit(dates, prices)
    #  svr_poly.fit(dates, prices)
    svr_rbf.fit(dates, prices)

    plt.scatter(dates, prices, color='black', label='Data')
    plt.plot(dates, svr_rbf.predict(dates), color='red', label='RBF model')
    plt.plot(dates, svr_lin.predict(dates), color='green', label='Linear model')
    #  plt.plot(dates, svr_poly.predict(dates), color = 'blue', label = 'Polinomial model')

    plt.xlabel('Date')
    plt.ylabel('Price')
    plt.title('Support Vector Regression')
    plt.legend()
    plt.show()

    return svr_rbf.predict(x)[0], svr_lin.predict(x)[0]  # , svr_poly.predict(x)[0]


if __name__ == "__main__":
    # df = get_data(r'C:\Users\andre\Desktop\DeBa\Javito\javito\lol.csv')
    # dates = df['Date']
    # price = df['Price']
    predicted_price = predict_prices(dates, prices, 100)
    print(predicted_price)
