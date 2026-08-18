DROP DATABASE IF EXISTS quiz_db;
CREATE DATABASE quiz_db;
USE quiz_db;

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50) NOT NULL,
    question_text VARCHAR(255) NOT NULL,
    option_a VARCHAR(100) NOT NULL,
    option_b VARCHAR(100) NOT NULL,
    option_c VARCHAR(100) NOT NULL,
    option_d VARCHAR(100) NOT NULL,
    correct_option CHAR(1) NOT NULL
);

CREATE TABLE players (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    score INT NOT NULL DEFAULT 0,
    total_questions INT NOT NULL DEFAULT 0,
    played_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crops questions
INSERT INTO questions (category, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES
('Crops', 'What is the main staple food crop of Bangladesh?', 'Wheat', 'Rice', 'Maize', 'Barley', 'B'),
('Crops', 'Which crop is known as the "Golden Fiber" of Bangladesh?', 'Cotton', 'Silk', 'Jute', 'Wool', 'C'),
('Crops', 'Sugar is commercially extracted from which of these crops?', 'Sugarcane', 'Sugar beet', 'Both A and B', 'Wheat', 'C'),
('Crops', 'Which crop is the primary source of vegetable (edible) oil in Bangladesh?', 'Rice', 'Mustard', 'Jute', 'Cotton', 'B'),
('Crops', 'Tea is mainly cultivated in which region of Bangladesh?', 'Rajshahi', 'Sylhet', 'Khulna', 'Barisal', 'B');

-- Geography questions
INSERT INTO questions (category, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES
('Geography', 'What is the capital of Bangladesh?', 'Chittagong', 'Dhaka', 'Khulna', 'Sylhet', 'B'),
('Geography', 'Which is the largest continent in the world by area?', 'Africa', 'Asia', 'Europe', 'Australia', 'B'),
('Geography', 'Mount Everest is located in which country?', 'Nepal', 'India', 'China', 'Bhutan', 'A'),
('Geography', 'Which is the largest ocean in the world?', 'Atlantic Ocean', 'Indian Ocean', 'Pacific Ocean', 'Arctic Ocean', 'C'),
('Geography', 'The Sundarbans mangrove forest is shared between Bangladesh and which country?', 'India', 'Myanmar', 'Nepal', 'Bhutan', 'A');

-- Academic Institutions questions
INSERT INTO questions (category, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES
('Academic Institutions', 'What does MBSTU stand for?', 'Mawlana Bhashani Science and Technology University', 'Multipurpose Business Studies and Technology University', 'Mymensingh Basic Science and Technology University', 'Modern Business School and Technical University', 'A'),
('Academic Institutions', 'Which is the oldest university in Bangladesh?', 'Dhaka University', 'Rajshahi University', 'Chittagong University', 'BUET', 'A'),
('Academic Institutions', 'What does BUET stand for?', 'Bangladesh University of Engineering and Technology', 'Bangladesh Union of Engineering Trainees', 'Bangladesh Undergraduate Education Trust', 'Bangladesh University of Emerging Technology', 'A'),
('Academic Institutions', 'Which of these is a public university in Bangladesh?', 'MBSTU', 'Harvard', 'Oxford', 'MIT', 'A'),
('Academic Institutions', 'In which year was Dhaka University established?', '1921', '1947', '1971', '1905', 'A');
