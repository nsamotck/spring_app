# CONTACTS-APP

## Список команд для работы с приложением
- `/add` - добавить контакт в формате "ФИО;номер телефона;адрес электронной почты"
- `/del` - удалить контакт по его email
- `/exit` - выйти из приложения
- `/help` - получить список опций для работы с приложением
- `/save` - сохранить имеющиеся контакты в файл (`build/resources/main/csv/runtime-contacts.csv`)
- `/show` - показать список всех имеющихся контактов

## Профили приложения
Управление профилями приложения осуществляется через файл `application.properties`.
По умолчанию приложение запускается с профилем `default` - список контактов изначально пуст.
Для инициализации списка контактов из файла `build/resources/main/csv/init-contacts.csv` используйте профиль `init`