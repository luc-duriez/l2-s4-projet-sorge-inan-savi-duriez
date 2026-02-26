JC = javac

SRC_DIR = src
TEST_DIR = test
CLASSES_DIR = classes

SOURCES = $(shell find $(SRC_DIR) -name "*.java")
TEST_SOURCES = $(shell find $(TEST_DIR) -name "*.java")

.PHONY: all docs classes jar tests runtests clean

all: classes

docs: classes
	mkdir -p docs
	javadoc -sourcepath $(SRC_DIR) -subpackages btd -d docs

classes:
	mkdir -p $(CLASSES_DIR)
	$(JC) -d $(CLASSES_DIR) $(SOURCES)

jar: classes
	jar cfe Livrable/Livrable4/livrable4a.jar btd.utils.MainClassic -C $(CLASSES_DIR) .
	jar cfe Livrable/Livrable4/livrable4b.jar btd.utils.MainLinear -C $(CLASSES_DIR) .

tests: classes
	$(JC) -classpath junit-console.jar:$(CLASSES_DIR) $(TEST_SOURCES) -d $(CLASSES_DIR)

runtests: tests
	java -jar junit-console.jar -classpath $(TEST_DIR):$(CLASSES_DIR) -scan-classpath


clean:
	rm -rf $(CLASSES_DIR) docs
