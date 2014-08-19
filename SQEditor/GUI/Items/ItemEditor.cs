using SQEditor.GameObjects;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SQEditor.GUI.Items
{
    public partial class ItemEditor : Form
    {
        public ItemEditor()
        {
            InitializeComponent();
            toolTip.SetToolTip(pbItemArtwork, "Click to choose the Item's artwork.");
        }

        private void pbItemArtwork_Click(object sender, EventArgs e)
        {
            var fileDialog = new OpenFileDialog();
            fileDialog.Filter = "PNG|*.png|JPEG|*.jpg;*.jpeg;*.jpe|GIF|*.gif";
            fileDialog.Title = "Choose Artwork";

            if (fileDialog.ShowDialog() == DialogResult.OK) {
                var item = new Item();
                item.ImagePath = fileDialog.FileName;
                var image = new FileStream(fileDialog.FileName, FileMode.Open);
                pbItemArtwork.Image = Image.FromStream(image);
            }
        }

        private void tsiNew_Click(object sender, EventArgs e)
        {
            ItemEffect.EffectType type;

            if (lbUseEffects.Visible) {
                type = ItemEffect.EffectType.Use;
            } else {
                type = ItemEffect.EffectType.Equip;
            }
            var form = new EffectEditor(type);
            form.ShowDialog();

        }
    }
}
