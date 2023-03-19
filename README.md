# speedys-mod

This is playground Minecraft Mod for various things I want to try out.

## Building and Running
The official Minecraft Forge Getting Started documentation can be found [here](https://docs.minecraftforge.net/en/1.19.x/gettingstarted/#getting-started-with-forge). The major difference is, instead of downloading the MDK you would clone this repo.
 1. Get the code from this repo. A couple possible ways:
    1. (Preferred) Clone this repo of which there a number of ways, one way is:
       * ` $ git clone https://github.com/JacksonFradley/MinecraftForge.git`
    2. Or download ZIP of project. Click the `Code` button and select `Download Zip`
 2. Generate the run helper files by running the following from within the root folder run:
    * `$ gradlew genEclipseRuns`
 3. Build the code:
    * `$ gradlew build`
 4. Run a local Minecraft client with the Mod:
    * `$ gradlew runClient`
