#!/bin/bash

# Trap Ctrl+C (SIGINT) to kill all child processes when the script exits
trap 'kill $(jobs -p)' EXIT

# Run delivery-service in the background
./mvnw -pl delivery-service &

# Run order-service in the background
./mvnw -pl order-service &

# Wait for both services to finish
wait