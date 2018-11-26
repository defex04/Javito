import pylab
import numpy

x = numpy.linspace(-15, 15, 100)  # 100 linearly spaced numbers
y = numpy.sin(x) / x  # computing the values of sin(x)/x

# compose plot
# pylab.plot(x, y)  # sin(x)/x
# pylab.plot(x, y, 'co')  # same function with cyan dots
# pylab.plot(x, 2 * y, x, 3 * y)  # 2*sin(x)/x and 3*sin(x)/x
# pylab.show()  # show the plot

print(x)
