#!/bin/bash
#FDSS Docker 安装脚本 作者：🌃梦幻◎星空🌃
NAME=v1.0.0
VERSION=202402030
R="[1;31m" G="[1;32m" Y="[1;33m" C="[1;36m" B="[1;m" O="[m"
echo "
$B———————————————————————————
$R FDSS$Y Project$G Docker$C Script$O
    $G$NAME$C ($VERSION)$O
$B———————————————————————————
    $G作者：$C🌃梦幻◎星空🌃$O
"

# 删除旧DockerCompose容器
echo "$Y- 删除旧容器$O"
docker-compose down --remove-orphans
echo "$Y- 构建新容器并启动$O"
docker-compose up --build -d --force-recreate