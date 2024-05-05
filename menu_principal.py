import tkinter as tk

class MenuPrincipal(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Menu Principal")

        # Créer la carte du monde avec les data centers
        self.canvas = tk.Canvas(self, width=800, height=600, bg="white")
        self.canvas.pack()

        # Ajouter des data centers sur la carte
        self.data_centers = []
        self.data_centers.append({"x": 100, "y": 100, "color": "red"})  # Exemple de data center
        self.data_centers.append({"x": 200, "y": 200, "color": "blue"})  # Autre exemple de data center

        for data_center in self.data_centers:
            x, y = data_center["x"], data_center["y"]
            data_center["id"] = self.canvas.create_oval(x, y, x + 20, y + 20, fill=data_center["color"])

        # Associer un événement clic à chaque data center
        for data_center in self.data_centers:
            self.canvas.tag_bind(data_center["id"], "<Button-1>", self.ouvrir_data_center)

    def ouvrir_data_center(self, event):
        # Fonction appelée lorsque l'utilisateur clique sur un data center
        # Afficher un menu avec les options disponibles pour ce data center
        data_center_id = event.widget.find_closest(event.x, event.y)[0]
        for data_center in self.data_centers:
            if data_center["id"] == data_center_id:
                print("Ouvrir DataCenter", data_center)

if __name__ == "__main__":
    app = MenuPrincipal()
    app.mainloop()