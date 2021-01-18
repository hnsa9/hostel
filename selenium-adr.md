#1. Selenium for XpressAI Automation

**Date:** 18-01-2021

**Status**

Proposed

**Context**

There is a need for automation to make it easier to integrate the model from Engine to their application. 

The framework should be able to automate web browsers and the script should be implemented in Python in order to be integrated with the Engine as part of the components. The script can be executed from the command line. The user input would be used as variables and passed into the script. 

The framework should be able to run in other operating systems such as Linux, as the server would be hosted on Linux. 
 
**Decision**

Use Selenium as the base framework for the automation and create a Python library that can be easily installed via pip. 

**Consequences**

* Can implement and automate various browser actions such as click, input text and others. 

* Easy implementation as the Selenium library only needs to be installed and imported inside the plain Python script for it to run. 

* Can be run across multiple browsers and operating systems.

* Can write advanced test scripts for various use cases and complexity. 

* Can be integrated with other tools to extend its functionality.
