import matplotlib.pyplot as plt
import numpy as np


x = [i*0.5 for i in range(0, 11)]
y = [i**2 for i in x]
z = [i**3 for i in x]
#create a reference to the newly created figure instance in the fig variable, 
#and from it we create a new axis instance axes using the add_axes method in
#the Figure class instance fig:

fig = plt.figure()
axes = fig.add_axes([0.1, 0.1, 0.8, 0.8]) # left, bottom, width, height (range 0 to 1)
axes.plot(x, y, 'r')
axes.set_xlabel('x') #set x label
axes.set_ylabel('y') #set y label
axes.set_title('Figure 1') #set title
axes.grid(True) #add grid
plt.show()

#input()
#Although a little bit more code is involved, the advantage is that we now have 
#full control of where the plot axes are placed, and we can easily add
#more than one axis to the figure:
fig = plt.figure()
axes1 = fig.add_axes([0.1, 0.1, 0.8, 0.8]) # main axes
axes2 = fig.add_axes([0.2, 0.5, 0.4, 0.3]) # inset axes
# main figure
axes1.plot(x, y, 'r')
axes1.set_xlabel('x')
axes1.set_ylabel('y')
axes1.set_title('Figure 2')
# insert
axes2.plot(y, x, 'g')
axes2.set_xlabel('y')
axes2.set_ylabel('x')
axes2.set_title('insert title')
plt.show()

#input()
#If we don't care about being explicit about where our plot axes are placed 
#in the figure canvas, then we can use one of the many axis layout
#managers in matplotlib: subplots, which can be used like this:
fig, axes = plt.subplots(nrows=1, ncols=2)
for ax in axes:
    ax.plot(x, y, 'r')
    ax.set_xlabel('x')
    ax.set_ylabel('y')
    ax.set_title('title')
fig.tight_layout()#automatically adjusts the positions of the axes so that
                  #there is no overlapping content:
plt.show()

#input()
#Matplotlib allows the aspect ratio, DPI and figure size to be specified 
#when the Figure object is created, using the figsize and dpi keyword arguments.
#figsize is a tuple of the width and height of the figure in inches, 
#and dpi is the dots-per-inch (pixel per inch). 
#To create an 800x400 pixel, 100 dots-per-inch figure, we can do:
fig, axes = plt.subplots(figsize=(12,3), dpi=100)
axes.plot(x, y, 'r')
axes.set_xlabel('x')
axes.set_ylabel('y')
axes.set_title('title')

fig, axes = plt.subplots(figsize=(8,4), dpi=100)
axes.plot(x, y, 'r')
axes.set_xlabel('x')
axes.set_ylabel('y')
axes.set_title('title')
plt.show()

#input()
#plot multiple curves in the same graph with Legends
#Legends for curves in a figure can be added using the label="label text" keyword 
#argument when plots or other objects are added to the figure, and 
#then using the legend method without arguments to add the legend to the figure: 
fig, axes = plt.subplots(figsize=(8,4), dpi=100)
axes.plot(x, y, label="area")
axes.plot(x, z, label="volume")
axes.set_xlabel('x')
axes.set_ylabel('y')
axes.set_title('title')
axes.legend()
plt.show()
#axes.legend(loc=0) # let matplotlib decide the optimal location
#axes.legend(loc=1) # upper right corner
#axes.legend(loc=2) # upper left corner
#axes.legend(loc=3) # lower left corner
#axes.legend(loc=4) # lower right corner
## .. many more options are available

#input()
#different y axes, modify line width
fig, ax1 = plt.subplots(figsize=(12,6))
ax1.plot(x, y, lw=2, color="blue") #lw is line width
ax1.set_ylabel(r"area $(m^2)$", fontsize=18, color="blue")
for label in ax1.get_yticklabels():
 label.set_color("blue")

ax2 = ax1.twinx()
ax2.plot(x, z, lw=4, color="red")
ax2.set_ylabel("volume $(m^3)$", fontsize=18, color="red")
for label in ax2.get_yticklabels():
 label.set_color("red")
plt.show()

#input()
#other 2D plot styles
n = np.array([0,1,2,3,4,5])
xx = np.linspace(-0.75, 1., 100)
fig, axes = plt.subplots(1, 4, figsize=(18,6))
axes[0].scatter(xx, xx + 0.25*np.random.randn(len(xx)))
axes[0].set_title("scatter")
axes[1].step(n, n**2, lw=2)
axes[1].set_title("step")
axes[2].bar(n, n**2, align="center", width=0.5, alpha=0.5)
axes[2].set_title("bar")
axes[3].fill_between(x, y, z, color="green", alpha=0.5)
axes[3].set_title("fill_between")
plt.show()