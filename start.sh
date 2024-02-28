#!/bin/bash
docker-compose down
docker-compose -f docker-compose.service.yml up --build -d --force-recreate