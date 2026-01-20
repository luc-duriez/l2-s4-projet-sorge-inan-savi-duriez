JC = javac

SRC_DIR = src
TEST_DIR = test
CLASSES_DIR = classes

SOURCES = $(shell find $(SRC_DIR) -name "*.java")
TEST_SOURCES = $(shell find $(TEST_DIR) -name "*.java")

.PHONY: all clean compile

all: compile

compile: $(CLASSES_DIR)
	$(JC) -d $(CLASSES_DIR) $(SOURCES)

$(CLASSES_DIR):
	mkdir -p $(CLASSES_DIR)

test: compileTest

compileTest: $(CLASSES_DIR)
	$(JC) -classpath junit-console.jar:classes $(TEST_SOURCES) -d $(CLASSES_DIR)

clean:
	rm -rf $(CLASSES_DIR)
