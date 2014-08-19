using SQEditor.GameObjects;
using SQEditor.GameObjects.ItemEffects;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SQEditor.GUI.Items
{
    public partial class EffectEditor : Form
    {
        public ItemEffect effect;

        public EffectEditor(ItemEffect.EffectType effectType)
        {
            InitializeComponent();

            effect = new ItemEffect();
            effect.Type = effectType;
            this.Text = ItemEffect.TypeToString(effectType) + " | StoneQuest";
        }

        private void tbScriptText_KeyUp(object sender, KeyEventArgs e)
        {
            var charCount = tbScriptText.Text.Length;
            labelRemainingChars.Text = charCount + " / 250";
        }

        #region Button Clicks

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (HasErrors()) {
                if (MessageBox.Show("", "") != DialogResult.OK) {
                    return;
                }
            }

            effect = new ItemEffect();
            effect.Name = tbDisplayText.Text;
            effect.Script = tbScriptText.Text;

            Close();
        }

        private bool HasErrors()
        {
            return String.IsNullOrEmpty(tbDisplayText.Text)
                || String.IsNullOrEmpty(tbScriptText.Text);
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            Close();
        }

        #endregion
    }
}
