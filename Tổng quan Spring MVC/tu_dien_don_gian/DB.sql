create database tu_dien_don_gian;

use tu_dien_don_gian;

create table tu_dien (
    id int auto_increment primary key,
    english_word varchar(255) not null,
    vietnamese_word varchar(255) not null
);

insert into tu_dien (english_word, vietnamese_word) values
('hello', 'xin chào'),
('book', 'quyển sách'),
('computer', 'máy tính'),
('apple', 'quả táo'),
('table', 'cái bàn'),
('chair', 'cái ghế'),
('student', 'học sinh'),
('teacher', 'giáo viên'),
('school', 'trường học'),
('pen', 'cây bút'),
('pencil', 'bút chì'),
('phone', 'điện thoại'),
('car', 'xe ô tô'),
('cat', 'con mèo'),
('dog', 'con chó'),
('sun', 'mặt trời'),
('moon', 'mặt trăng'),
('water', 'nước'),
('food', 'thức ăn'),
('love', 'tình yêu');

