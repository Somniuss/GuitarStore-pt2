package com.somniuss.guitarstore.dao.impl;

import com.somniuss.guitarstore.dao.GuitarStoreDao;
import com.somniuss.guitarstore.entity.BassGuitar;
import com.somniuss.guitarstore.entity.ElectricGuitar;
import com.somniuss.guitarstore.entity.MusicalInstrument;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileGuitarStoreDao implements GuitarStoreDao {

    private static final String FILE_NAME = "instruments.txt";

    @Override
    public void addInstrument(MusicalInstrument instrument) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(convertInstrumentToString(instrument));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MusicalInstrument findInstrumentById(int id) {
        return getAllInstruments().stream()
                .filter(instrument -> instrument.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<MusicalInstrument> findInstrumentsByType(String type) {
        return getAllInstruments().stream()
                .filter(instrument -> instrument.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<MusicalInstrument> findInstrumentsByBrand(String brand) {
        return getAllInstruments().stream()
                .filter(instrument -> instrument.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<MusicalInstrument> sortInstrumentsByPrice(boolean ascending) {
        return getAllInstruments().stream()
                .sorted(Comparator.comparingDouble(MusicalInstrument::getPrice)
                        .reversed().reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<MusicalInstrument> filterInstrumentsByPrice(double maxPrice) {
        return getAllInstruments().stream()
                .filter(instrument -> instrument.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    @Override
    public void updateInstrument(MusicalInstrument instrument) {
        List<MusicalInstrument> instruments = getAllInstruments();
        int index = instruments.indexOf(findInstrumentById(instrument.getId()));
        if (index >= 0) {
            instruments.set(index, instrument);
            writeAllInstrumentsToFile(instruments);
        }
    }

    @Override
    public boolean deleteInstrumentById(int id) {
        List<MusicalInstrument> instruments = getAllInstruments();
        boolean removed = instruments.removeIf(instrument -> instrument.getId() == id);
        if (removed) {
            writeAllInstrumentsToFile(instruments);
        }
        return removed;
    }

    private List<MusicalInstrument> getAllInstruments() {
        List<MusicalInstrument> instruments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                instruments.add(convertStringToInstrument(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instruments;
    }

    private void writeAllInstrumentsToFile(List<MusicalInstrument> instruments) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (MusicalInstrument instrument : instruments) {
                writer.write(convertInstrumentToString(instrument));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertInstrumentToString(MusicalInstrument instrument) {
        String base = instrument.getId() + "," + instrument.getType() + "," + instrument.getBrand() + "," +
                instrument.getModel() + "," + instrument.getPrice();
        
        if (instrument instanceof ElectricGuitar) {
            ElectricGuitar eg = (ElectricGuitar) instrument;
            return base + "," + eg.getBodyShape() + "," + eg.getTremoloSystem();
        } else if (instrument instanceof BassGuitar) {
            BassGuitar bg = (BassGuitar) instrument;
            return base + "," + bg.getElectronics();
        }
        
        return base;
    }

    private MusicalInstrument convertStringToInstrument(String line) {
        String[] parts = line.split(",");
        
        if (parts.length < 5) {
            throw new IllegalArgumentException("Invalid data format: " + line);
        }

        int id = Integer.parseInt(parts[0]);
        String type = parts[1];
        String brand = parts[2];
        String model = parts[3];
        double price = Double.parseDouble(parts[4]);

        if (type.equalsIgnoreCase("ElectricGuitar")) {
            if (parts.length < 7) {
                throw new IllegalArgumentException("Invalid data format for ElectricGuitar: " + line);
            }
            return new ElectricGuitar(id, type, brand, model, price, parts[5], parts[6]);
        } else if (type.equalsIgnoreCase("BassGuitar")) {
            if (parts.length < 6) {
                throw new IllegalArgumentException("Invalid data format for BassGuitar: " + line);
            }
            return new BassGuitar(id, type, brand, model, price, parts[5]);
        }

        return new MusicalInstrument(id, type, brand, model, price);
    }

}
