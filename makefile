JC = javac

SRC_DIR = src
TEST_DIR = test
CLASSES_DIR = classes

SOURCES = $(shell find $(SRC_DIR) -name "*.java")
TEST_SOURCES = $(shell find $(TEST_DIR) -name "*.java")
CLASSES = $(shell find $(TEST_DIR) -name "*.class")

.PHONY: all clean compile

all: compile

compile: $(SOURCES)
	$(JC) -d $(CLASSES_DIR) $(SOURCES)

$(CLASSES): $(CLASSES:.class=.java)

$(CLASSES_DIR):
	mkdir -p $(CLASSES_DIR)

test: compileTest execTest

compileTest: $(CLASSES_DIR)
	$(JC) -classpath junit-console.jar:classes $(TEST_SOURCES) -d $(CLASSES_DIR)

execTest: 
	java -jar junit-console.jar -classpath test:classes -scan-classpath

jar classic:
	jar cvfe Livrable/Livrable1a.jar btd.utils.MainClassic -C classes .
jar linear:
	jar cvfe Livrable/Livrable1b.jar btd.utils.MainLinear -C classes .



clean:
	rm -rf $(CLASSES_DIR)
