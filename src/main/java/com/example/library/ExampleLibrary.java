package com.example.library;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.adventure.audience.Audiences;

public class ExampleLibrary {
    public void helloworld() {
        Audiences.all().sendMessage(Component.text("Hello from library", NamedTextColor.DARK_PURPLE));
    }
}
