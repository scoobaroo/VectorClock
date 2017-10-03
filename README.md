Project Title:  Java Implementation for calculation of Vector Clocks.

Overview:
This is homework assignment for CS249 Distributed Computing course at SJSU, Fall 2017. This program is implemented to calculate the Vector Clocks of processors. Implementation has following classes:

Algorithm.java
In this module, processors their events are hardcoded as the execution plan. It also contains a main() method, which sets the number of processors and calls out to execute the execution plan.

Buffer.java
Buffer is an observable of a processor and it notifies its processor instance of any change in its state.

Event.java
Event sets the event type and Vector clocks of processors.

EventType.java
Event type is an enum and has three values, i.e. Compute, Send and Receive.

Message.java
Message is used to implement the sending of messages from one processor to another. Also it defines what kind of message was sent or received, i.e. if the event was a send event or receive.

Processor.java
This module implements Observer interface and thus provides implementation for update() method of observer. Update method decides processor's behavior after being notified by a change in observable buffer.
Processor also implements threads that run in parallel for each processor. It also implements the compare to method that compares the vector clocks in case of receive events.

VectorClocks.java
It stores the vector clocks of processors in an array.

Input:
The Processors and their Events are hardcoded in the program as Execution Plan.
Output:
The program gives updated Vector Clocks of the processors as the output.
