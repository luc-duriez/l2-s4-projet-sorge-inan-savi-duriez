JC = javac

SRC_DIR = src
CLASSES_DIR = classes

SOURCES = $(shell find $(SRC_DIR) -name "*.java")

.PHONY: all clean compile

all: compile

compile: $(CLASSES_DIR)
	$(JC) -d $(CLASSES_DIR) $(SOURCES)

$(CLASSES_DIR):
	mkdir -p $(CLASSES_DIR)

clean:
	rm -rf $(CLASSES_DIR)