using SQEditor.GameObjects.ItemEffects;
using SQEditor.GameObjects.Items;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Windows.Forms;

namespace SQEditor.GUI.Items
{
    public partial class ItemEditor : Form
    {
        #region Data

        private Item item;
        private List<ItemEffect> UseEffects;
        private List<ItemEffect> EquipEffects;

        #endregion

        #region Constructor

        public ItemEditor()
        {
            InitializeComponent();
            toolTip.SetToolTip(pbItemArtwork, "Click to choose the Item's artwork.");

            item = new Item();
            UseEffects = new List<ItemEffect>();
            EquipEffects = new List<ItemEffect>();

            InvalidateListBoxes();
        }

        #endregion

        #region Invalidate Components

        private void InvalidateListBoxes()
        {
            lbUseEffects.DataSource = null;
            lbUseEffects.DataSource = UseEffects;
            lbUseEffects.DisplayMember = "Name";

            lbEquipEffects.DataSource = null;
            lbEquipEffects.DataSource = EquipEffects;
            lbEquipEffects.DisplayMember = "Name";
        }

        #endregion

        #region Button Clicks

        private void pbItemArtwork_Click(object sender, EventArgs e)
        {
            var fileDialog = new OpenFileDialog();
            fileDialog.Filter = "PNG|*.png|JPEG|*.jpg;*.jpeg;*.jpe|GIF|*.gif";
            fileDialog.Title = "Choose Artwork";

            if (fileDialog.ShowDialog() == DialogResult.OK) {
                var item = new Item();
                var image = new FileStream(fileDialog.FileName, FileMode.Open);
                pbItemArtwork.Image = Image.FromStream(image);
            }
        }

        private void tsiNew_Click(object sender, EventArgs e)
        {
            ItemEffect effect;
            var form = new EffectEditor();

            if (form.ShowDialog() == DialogResult.OK) {
                effect = form.effect;

                switch (effect.Type) {
                    case ItemEffect.EffectType.Use:
                        UseEffects.Add(effect);
                        break;

                    case ItemEffect.EffectType.Equip:
                        EquipEffects.Add(effect);
                        break;
                }

                InvalidateListBoxes();
            }
        }

        #endregion

        #region Save Button

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (HasErrors()) {
                return;
            }

            item.Name = tbName.Text;
            item.Artwork = pbItemArtwork.Image;
            item.Level = Convert.ToInt32(nudLevel.Value);
            item.SellValue = Convert.ToInt32(nudSellValue.Value);
            item.Description = tbDescription.Text;
            item.Type = tvType.SelectedNode.Text;

            foreach (var effect in UseEffects) {
                item.UseEffects.Add(effect);
            }

            foreach (var effect in EquipEffects) {
                item.EquipEffects.Add(effect);
            }

            XMLUtility.Save(item);

            DialogResult = DialogResult.OK;
            Close();
        }

        #endregion

        #region Validation

        private bool HasErrors()
        {
            var result = false;

            errorProvider.SetError(tbName, "");
            errorProvider.SetError(tvType, "");
            errorProvider.SetError(pbItemArtwork, "");

            if (String.IsNullOrEmpty(tbName.Text)) {
                errorProvider.SetError(tbName, "Item must have a name.");
                result = true;
            }

            if (tvType.SelectedNode == null || tvType.SelectedNode.Nodes.Count > 0) {
                errorProvider.SetError(tvType, "Item must have a type.");
                result = true;
            }

            if (pbItemArtwork.Image == null) {
                errorProvider.SetError(pbItemArtwork, "Item must have associated artwork.");
                result = true;
            }

            return result;
        }

        #endregion

        #region Update Remaining Characters

        private void tbDescription_TextChanged(object sender, EventArgs e)
        {
            var charCount = tbDescription.Text.Length;
            labelRemainingChars.Text = charCount + " / 100";
        }

        private void ItemEditor_Load(object sender, EventArgs e)
        {
            tbDescription_TextChanged(sender, e);
        }

        #endregion
    }
}
