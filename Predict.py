import csv
import numpy as np
from sklearn.svm import SVR
import matplotlib.pyplot as plt
import pandas as pd

dates = []
prices = []

def get_data(filename, curr):
    i = 0
    with open(filename, 'r') as csvfile:
        csvfileReader = csv.reader(csvfile, delimiter = ';')
        next(csvfileReader)
        for row in csvfileReader:
            if curr in 'usd':
                dates.append(i)
                prices.append(float(row[1]))
                i = i + 1
            elif curr in 'gbp':
                dates.append(i)
                prices.append(float(row[2]))
                i = i + 1
            elif curr in 'eur':
                dates.append(i)
                prices.append(float(row[3]))
                i = i + 1
    return 
    
def predict_prices(dates, prices, x):
    dates = np.reshape(dates, (len(dates), 1))
    svr_lin = SVR(kernel = 'linear', C=1000)
  #  svr_poly = SVR(kernel = 'poly', C=1e3, degree = 2)
    svr_rbf = SVR(kernel = 'rbf', C=1000, gamma = 10)
    svr_lin.fit(dates, prices)
  #  svr_poly.fit(dates, prices)
    svr_rbf.fit(dates, prices)
    
    plt.scatter(dates, prices, color='black', label = 'Data')
    plt.plot(dates, svr_rbf.predict(dates), color='red', label='RBF model')
    plt.plot(dates, svr_lin.predict(dates), color = 'green', label = 'Linear model')
  #  plt.plot(dates, svr_poly.predict(dates), color = 'blue', label = 'Polinomial model')
    
    plt.xlabel('Date')
    plt.ylabel('Price')
    plt.title('Support Vector Regression')
    plt.legend()
    plt.show()
    
    return svr_rbf.predict(x)[0]#, svr_lin.predict(x)[0]#, svr_poly.predict(x)[0]

get_data('data1.csv','gbp')
   
print(prices)

predict = predict_prices(dates, prices, 30)
print(predict)
