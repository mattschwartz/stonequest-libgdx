using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using SQEditor.Properties;

namespace SQEditor.GUI.Tiles
{
    public partial class ucTileOverview : UserControl
    {
        private string TileDirectoryPath;

        public ucTileOverview()
        {
            InitializeComponent();
            InitializeWatcher();
            LoadTiles();
        }
        
        private void LoadTiles()
        {
            var tiles = new List<String>(Directory.GetFiles(TileDirectoryPath));

            panelEnvironmentTiles.Controls.Clear();
            tiles.ForEach(f => panelEnvironmentTiles.Controls.Add(PictureBoxFromPath(f)));
        }

        private PictureBox PictureBoxFromPath(string path)
        {
            Image imageCopy;

            using (var stream = new FileStream(path, FileMode.Open)) {
                imageCopy = Image.FromStream(stream);
            }

            var pictureBox = new PictureBox() {
                Image = imageCopy
            };

            pictureBox.Height = 32;
            pictureBox.Width = 32;

            return pictureBox;
        }

        #region File System Watcher

        private void InitializeWatcher()
        {
            TileDirectoryPath = FileUtility.GetResourcesRootPath() + "tiles\\";
            tileDirectoryMonitor.Path = TileDirectoryPath;
            tileDirectoryMonitor.Filter = "*.png";
            tileDirectoryMonitor.Created += TileDirectoryChanged;
            tileDirectoryMonitor.Deleted += TileDirectoryChanged;
            tileDirectoryMonitor.Changed += TileDirectoryChanged;
            tileDirectoryMonitor.EnableRaisingEvents = true;
        }

        private void TileDirectoryChanged(object sender, System.IO.FileSystemEventArgs e)
        {
            LoadTiles();
        }

        #endregion
    }
}
