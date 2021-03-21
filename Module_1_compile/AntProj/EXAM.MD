###Для того, чтобы подготовить Manifest введите следующую команду в терминал###
`$ echo Main-Class: com.company.Main>MANIFEST.MF`
### Далее введите следующую комманду для создание jar файла ###
`$ MD build\jar`
### Чтобы скомпилировать проект перейдите в AntProj и введите команду: ###
`$ >javac -sourcepath src\ -d build\classes\ src\com\company\Main.java`
### Создайте jar-файл с помощью следующей комманды: ###
`$ jar cfm build\jar\Main.jar MANIFEST.MF -C build\jar\ .`
###Run program###
`$ ant run`