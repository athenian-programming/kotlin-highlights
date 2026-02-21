default: versioncheck

build: clean
	./gradlew build -x test

website:
	mkdocs build --clean

serve:
	mkdocs serve

clean:
	rm -rf site

refresh:
	./gradlew --refresh-dependencies

versioncheck:
	./gradlew dependencyUpdates

upgrade-wrapper:
	./gradlew wrapper --gradle-version=9.3.1 --distribution-type=bin
